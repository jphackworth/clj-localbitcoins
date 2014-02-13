; Copyright (C) 2014 John. P Hackworth <jph@hackworth.be>
;
; This Source Code Form is subject to the terms of the Mozilla Public
; License, v. 2.0. If a copy of the MPL was not distributed with this
; file, You can obtain one at http://mozilla.org/MPL/2.0/.

(ns clj-localbitcoins.core
  (:require [org.httpkit.client :as http]
            [cheshire.core :refer :all]
            [clojure.string :refer [upper-case lower-case]]))

(def defaults (atom {:options {:content-type "application/json"
                               :user-agent "clj-localbitcoins 0.1.0"
                               :insecure? false
                               :keepalive -1}
                     :urls {:base "https://localbitcoins.com"
                            :countrycodes "/api/countrycodes/"
                            :currencies "/api/currencies/"
                            :places "/api/places/"
                            :payment-methods "/api/payment_methods/"
                            :buy-bitcoins-online "/buy-bitcoins-online/"
                            :sell-bitcoins-online "/sell-bitcoins-online/"
                            }
                     }))

; (defn buy-bitcoins-online [country-code country-name payment-method]
;   (let [base-url (:base (:urls @defaults))]
;     (format "%s%s%s%s%s/.json" base-url country-code country-name payment-method)))

(defn callback [{:keys [status headers body error opts] :as response}]
  (if error 
    (throw (Exception. (format "Failed, error: %s" error)))
    (case status 
      200 (:data (parse-string body true))
      (throw (Exception. response)))))

(defn api-call [options url & [method]]
  (println url)
  (case method 
    :get (http/get url options callback)
    :post (http/post url options callback)
    (http/get url options callback)))

(defn get-online-ads 
  "Takes a map argument with following keys:
  
  Minimum arguments: A map including the following key
  
  :kind :buy-bitcoins-online OR :sell-bitcoins-online 
  
  Optional keys:
  
  :payment-method from @(get-payment-methods)
  :currency from @(get-currencies)
  :country-code from @(get-country-codes)
  :country-name (spaces in name must include %20 (ie \"Hong%20Kong\"))
  
  Example usage:
  
  @(get-online-ads {:kind :buy-bitcoins-online})
  @(get-online-ads {:kind :buy-bitcoins-online :currency \"USD\"})
  @(get-online-ads {:kind :sell-bitcoins-online :payment-method :transfers-with-specific-bank})
  @(get-online-ads {:kind :sell-bitcoins-online :currency \"USD\" :payment-method :transfers-with-specific-bank})
  "
  [{:keys [kind country-code country-name payment-method currency]}]
  (let [base-url (:base (:urls @defaults)) options (:options @defaults)]
    (if (and country-code country-name payment-method) 
      (api-call options 
                (format "%s%s%s/%s/%s/.json" base-url (kind (:urls @defaults)) country-code country-name (name payment-method))
                :get)
      (if (and country-code country-name) 
        (api-call options 
                  (format "%s%s%s/%s/.json" base-url (kind (:urls @defaults)) country-code country-name) :get) 
        (if (and currency payment-method) 
          (api-call options (format "%s%s%s/%s/.json" base-url (kind (:urls @defaults)) (name currency) (name payment-method)) :get)
          (if-not (nil? currency)
            (api-call options (format "%s%s%s/.json" base-url (kind (:urls @defaults)) (name currency)) :get)
            (if-not (nil? payment-method) 
              (api-call options (format "%s%s%s/.json" base-url (kind (:urls @defaults)) (name payment-method)) :get)
              (if-not (nil? kind) 
                (api-call options (format "%s%s/.json" base-url (kind (:urls @defaults))) :get)
                (throw (Exception. "Must at minimum specify a :kind of :buy-bitcoins-online or :sell-bitcoins-online"))))))))))
                     
(defn get-payment-methods 
  "Get all payment methods, or payment methods available for a specific country.
  
  Minimum arguments: none 
  
  Optional arguments: valid country code from @(get-country-codes)
  "
  [& [country-code]]
  (let [url (format "%s%s" (:base (:urls @defaults)) (:payment-methods (:urls @defaults)))]
    (if (nil? country-code) 
      (api-call (:options @defaults) url :get)
      (api-call (:options @defaults) (format "%s%s/" url country-code) :get))))

(defn get-country-codes 
  "Returns valid country codes for use with the API.
  
  Arguments: none 
  "
  [] 
  (let [url (format "%s%s" (:base (:urls @defaults)) (:countrycodes (:urls @defaults)))]
    (api-call (:options @defaults) url :get))) 

(defn get-currencies 
  "Returns valid currencies. 
  
  Arguments: none 
  "
  [] 
  (let [url (format "%s%s" (:base (:urls @defaults)) (:currencies (:urls @defaults)))]
    (api-call (:options @defaults) url :get)))