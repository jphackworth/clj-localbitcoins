# clj-localbitcoins

Clojure library for [Localbitcoins Public API](https://localbitcoins.com/api-docs/public/).

Support for the [logged-in API](https://localbitcoins.com/api-docs/) is planned.

Still in early stages of development, not available on Clojars yet.

## Usage

The following functions are available:

- (get-currencies)
- (get-country-codes)
- (get-payment-methods)
- (get-online-ads)

### (get-currencies)

Returns valid currencies for use on Localbitcoins.

Arguments: none.

Example:

```Clojure
user=> @(get-currencies)
{:currencies {:AMD {}, :LSL {}, :DOP {}, :SDG {}, :ERN {}, :FKP {}, :EEK {}, :KYD {}, :MZN {}, :MMK {:name "Burmese Kyat"}, :SYP {}, :SVC {}, :IDR {:name "Indonesian Rupiah"}, :MUR {}, :NOK {:name "Norwegian Krona"}, :BGN {}, :GEL {}, :GIP {}, :XOF {}, :BOB {}, :ARS {:name "Argentine Peso"}, :ZWL {}, :QAR {:name "Qatari Riyal"}, :MDL {}, :KHR {}, :TMT {}, :YER {}, :ILS {:name "Israeli Shekel"}, :AUD {:name "Australian Dollar"}, :LTL {}, :SLL {}, :PYG {}, :BSD {}, :SAR {:name "Saudi Riyal"}, :PEN {:name "Peruvian New Sol"}, :TTD {:name "Trinidad and Tobago Dollar"}, :SRD {}, :WST {}, :RUB {:name "Russian Ruble"}, :NZD {:name "New-Zealand Dollar"}, :GHS {}, :KPW {}, :KZT {:name "Tenge"}, :BND {}, :SZL {}, :BIF {}, :ZMK {}, :GYD {}, :JMD {:name "Jamaican Dollar"}, :MWK {}, :VND {:name "Vietnamese Dong"}, :XAU {}, :ZAR {:name "South African Rand"}, :ISK {}, :TZS {}, :TND {}, :PKR {}, :CZK {:name "Czech Koruna"}, :PGK {}, :OMR {}, :CRC {}, :XAR {}, :NGN {}, :TOP {}, :AZN {}, :UYU {}, :BTN {}, :MKD {}, :BYR {:name "Belarusian Ruble"}, :RON {:name "Romanian Leu"}, :USD {:name "US Dollar"}, :XDR {}, :UAH {}, :MGA {}, :MAD {}, :LKR {}, :HUF {:name "Hungarian Forint"}, :BMD {:name "BermudIan Dollar"}, :COP {:name "Colombian Peso"}, :BHD {}, :GNF {}, :PHP {:name "Philippines Peso"}, :KWD {}, :CVE {}, :CHF {:name "Swiss Franc"}, :BZD {}, :HRK {:name "Croatian kuna"}, :ALL {}, :DJF {}, :FJD {}, :LYD {}, :BAM {}, :EGP {:name "Egyptian Pound"}, :STD {}, :MOP {}, :MXN {:name "Mexican Peso"}, :DZD {}, :LVL {}, :SBD {}, :GBP {:name "British Pound"}, :SCR {}, :AWG {}, :IQD {}, :HNL {}, :UGX {}, :HTG {}, :TJS {}, :NPR {}, :KRW {:name "South Korean won"}, :CLP {:name "Chilean Peso"}, :ANG {}, :GMD {}, :BBD {}, :KES {}, :GTQ {}, :MNT {}, :SEK {:name "Swedish Krona"}, :AOA {}, :CUP {}, :JPY {:name "Japanese Yen"}, :XCD {}, :ZMW {}, :MTL {}, :PLN {:name "Polish Zloty"}, :JOD {}, :CDF {}, :BDT {}, :RWF {}, :HKD {:name "Hong Kong Dollar"}, :TWD {:name "Taiwan Dollar"}, :LAK {}, :KGS {}, :SOS {}, :VUV {}, :INR {:name "Indian Rupee"}, :AED {:name "United Arab Emirates Dirham"}, :MRO {}, :VEF {}, :IRR {}, :CNY {:name "Chinese Renminbi"}, :NIO {}, :AFN {}, :RSD {}, :MVR {}, :UZS {}, :THB {:name "Thai Baht"}, :XPF {}, :EUR {:name "Euro"}, :JEP {}, :MYR {:name "Malaysian Ringgit"}, :PAB {}, :CAD {:name "Canadian Dollar"}, :BWP {}, :SHP {}, :TRY {:name "Turkish Lira"}, :BRL {:name "Brazilian Real"}, :NAD {}, :CLF {}, :XAF {}, :LBP {}, :SGD {:name "Singapore Dollar"}, :XAG {}, :DKK {:name "Danish Krona"}, :LRD {}, :ETB {}, :KMF {}}, :currency_count 166}
```

### (get-country-codes)

Returns valid country codes for use on Localbitcoins.

Arguments: none.

Example:

```Clojure
user=> @(get-country-codes)
{:cc_count 249, :cc_list ["AF" "AX" "AL" "DZ" "AS" "AD" "AO" "AI" "AQ" "AG" "AR" "AM" "AW" "AU" "AT" "AZ" "BS" "BH" "BD" "BB" "BY" "BE" "BZ" "BJ" "BM" "BT" "BO" "BQ" "BA" "BW" "BV" "BR" "IO" "BN" "BG" "BF" "BI" "KH" "CM" "CA" "CV" "KY" "CF" "TD" "CL" "CN" "CX" "CC" "CO" "KM" "CG" "CD" "CK" "CR" "CI" "HR" "CU" "CW" "CY" "CZ" "DK" "DJ" "DM" "DO" "EC" "EG" "SV" "GQ" "ER" "EE" "ET" "FK" "FO" "FJ" "FI" "FR" "GF" "PF" "TF" "GA" "GM" "GE" "DE" "GH" "GI" "GR" "GL" "GD" "GP" "GU" "GT" "GG" "GN" "GW" "GY" "HT" "HM" "VA" "HN" "HK" "HU" "IS" "IN" "ID" "IR" "IQ" "IE" "IM" "IL" "IT" "JM" "JP" "JE" "JO" "KZ" "KE" "KI" "KP" "KR" "KW" "KG" "LA" "LV" "LB" "LS" "LR" "LY" "LI" "LT" "LU" "MO" "MK" "MG" "MW" "MY" "MV" "ML" "MT" "MH" "MQ" "MR" "MU" "YT" "MX" "FM" "MD" "MC" "MN" "ME" "MS" "MA" "MZ" "MM" "NA" "NR" "NP" "NL" "NC" "NZ" "NI" "NE" "NG" "NU" "NF" "MP" "NO" "OM" "PK" "PW" "PS" "PA" "PG" "PY" "PE" "PH" "PN" "PL" "PT" "PR" "QA" "RE" "RO" "RU" "RW" "BL" "SH" "KN" "LC" "MF" "PM" "VC" "WS" "SM" "ST" "SA" "SN" "RS" "SC" "SL" "SG" "SX" "SK" "SI" "SB" "SO" "ZA" "GS" "ES" "LK" "SD" "SR" "SS" "SJ" "SZ" "SE" "CH" "SY" "TW" "TJ" "TZ" "TH" "TL" "TG" "TK" "TO" "TT" "TN" "TR" "TM" "TC" "TV" "UG" "UA" "AE" "GB" "US" "UM" "UY" "UZ" "VU" "VE" "VN" "VG" "VI" "WF" "EH" "YE" "ZM" "ZW"]}
```

### (get-payment-methods)

Returns list of valid payment methods for use on Localbitcoins.

Arguments: country-code (optional)

Example:

```Clojure
user=> @(get-payment-methods)
{:methods {:moneybookers-skrill {:code "MONEYBOOKERS", :name "Moneybookers / Skrill"}, :dwolla {:code "DWOLLA", :name "Dwolla"}, :moneygram {:code "MONEYGRAM", :name "Moneygram"}, :western-union {:code "WU", :name "Western Union"}, :postepay {:code "PostePay", :name "PostePay"}, :neteller {:code "NETELLER", :name "Neteller"}, :egopay {:code "EGOPAY", :name "EgoPay"}, :paysafecard {:code "PAYSAFECARD", :name "PaySafeCard"}, :cashiers-check {:code "CASHIERS_CHECK", :name "Cashier's check"}, :astropay {:code "ASTROPAY", :name "AstroPay"}, :transferwise {:code "TRANSFERWISE", :name "Transferwise"}, :transfers-with-specific-bank {:code "SPECIFIC_BANK", :name "Transfers with specific bank"}, :m-pesa-kenya-safaricom {:code "MPESA_KENYA", :name "M-PESA Kenya (Safaricom)"}, :moneypak {:code "MONEYPAK", :name "MoneyPak"}, :national-bank-transfer {:code "NATIONAL_BANK", :name "National bank transfer"}, :webmoney {:code "WEBMONEY", :name "WebMoney"}, :venmo {:code "VENMO", :name "Venmo"}, :international-wire-swift {:code "INTERNATIONAL_WIRE_SWIFT", :name "International Wire (SWIFT)"}, :perfect-money {:code "PERFECT_MONEY", :name "Perfect Money"}, :other-online-payment {:code "OTHER", :name "Other online payment"}, :interac-e-transfer {:code "INTERAC", :name "Interac e-transfer"}, :m-pesa-tanzania-safaricom {:code "MPESA_TANZANIA", :name "M-PESA Tanzania (Safaricom)"}, :pingit {:code "PINGIT", :name "Pingit"}, :uk-faster-payments {:code "UK_FASTER_PAYMENTS", :name "UK Faster Payments"}, :cash-by-mail {:code "CASH_BY_MAIL", :name "Cash by mail"}, :cash-deposit {:code "CASH_DEPOSIT", :name "Cash deposit"}, :postal-order {:code "POSTAL_ORDER", :name "Postal order"}, :okpay {:code "OKPAY", :name "OKPay"}, :alipay {:code "ALIPAY", :name "Alipay"}, :ukash {:code "UKASH", :name "Ukash"}, :sepa-eu-bank-transfer {:code "SEPA", :name "SEPA (EU) bank transfer"}, :cashu {:code "CASHU", :name "CashU"}, :payza {:code "PAYZA", :name "Payza"}, :telegramatic-order {:code "TELEGRAMATIC_ORDER", :name "Telegramatic Order"}, :chase-quickpay {:code "CHASE_QUICKPAY", :name "Chase Quickpay"}, :paypal {:code "PAYPAL", :name "Paypal"}}, :method_count 36}

; with country code argument
user=> @(get-payment-methods "JP")
https://localbitcoins.com/api/payment_methods/JP/
{:methods {:moneybookers-skrill {:code "MONEYBOOKERS", :name "Moneybookers / Skrill"}, :moneygram {:code "MONEYGRAM", :name "Moneygram"}, :western-union {:code "WU", :name "Western Union"}, :neteller {:code "NETELLER", :name "Neteller"}, :egopay {:code "EGOPAY", :name "EgoPay"}, :transferwise {:code "TRANSFERWISE", :name "Transferwise"}, :webmoney {:code "WEBMONEY", :name "WebMoney"}, :international-wire-swift {:code "INTERNATIONAL_WIRE_SWIFT", :name "International Wire (SWIFT)"}, :perfect-money {:code "PERFECT_MONEY", :name "Perfect Money"}, :okpay {:code "OKPAY", :name "OKPay"}, :ukash {:code "UKASH", :name "Ukash"}, :cashu {:code "CASHU", :name "CashU"}, :payza {:code "PAYZA", :name "Payza"}, :paypal {:code "PAYPAL", :name "Paypal"}}, :method_count 14}
```

### (get-online-ads params)

Returns online adds matching specified parameters.

Arguments: map (required)

Minimum keys:

- :kind - :buy-bitcoins-online OR :sell-bitcoins-online 

Optional keys:

- :payment-method from @(get-payment-methods)
- :currency from @(get-currencies)
- :country-code from @(get-country-codes)
- :country-name (spaces in name must include %20 (ie "Hong%20Kong")) ; warning - not well tested
 
Examples: 

```Clojure
user=> (def japan-buy-ads @(get-online-ads {:kind :buy-bitcoins-online :country-code "JP" :country-name "Japan"}))
#'user/japan-buy-ads

user=> (keys japan-buy-ads)
(:ad_list :ad_count)

user=> (:ad_count japan-buy-ads)
7

user=> (first (:ad_list japan-buy-ads))
{:data {:require_feedback_score 0, :visible true, :reference_type "SHORT", :bank_name "MUFJ / SMBC", :profile {:username "cpib70", :feedback_score 100, :trade_count "29", :last_online "2014-02-13T06:38:26+00:00", :name "cpib70 (29; 100%)"}, :currency "JPY", :online_provider "NATIONAL_BANK", :sms_verification_required false, :max_amount "100000", :ad_id 62627, :age_days_coefficient_limit "4.00", :trade_type "ONLINE_SELL", :location_string "Japan", :min_amount "5000", :temp_price_usd "941.51", :city "", :msg "日本語オーケーです。よろしくお願いします。\r\nContact hours: ANYTIME\r\n\r\nBANK : SMBC 三井住友銀行 OR MUFG 三菱東京UFJ銀行\r\nPLEASE FOLLOW THE STEPS :\r\n\r\n1) Place your order and mark sent request. (sent me a message to inform me which BANKS accounts you require)\r\n2) I will reply and provide you the requested bank account to deposit.\r\n3) Deposit the funds as your request.(CASH OR INTERNET BANK TRANSFER).\r\n4) After deposit / transfer, please mark PAYMENT COMPLETED / PAYMENT DONE!\r\n5) When I see money in the bank account. I will release BTC to your wallet. Usually i will release your BTC to you within mins\r\n(if you want to receive your BTC early, you can photo / screen shot and paste on the ATTACHED DOCUMENT  as proof)\r\n\r\nIf I fall asleep when you sent the request, I will reply you the next morning and if you are really to trade, I will reopen the trade for you! (same step as above after reopen the trade).\r\nPlease take note of below :\r\nDO NOT MARK PAYMENT COMPLETE WHEN YOU DID NOT RECEIVED MY BANK PAYMENT ACCOUNT INFORMATIONS\r\nIf you MARK PAYMENT COMPLETE before you deposit the funds, I will have to ask SUPPORT TEAMS to cancel the trade,you will be in my BLACKLIST and you will never come back! \r\nLet's make it clear and easy trade!\r\nThanks", :created_at "2013-12-22T13:49:22+00:00", :countrycode "JP", :require_trade_volume 0.0, :email nil, :max_amount_available "100000", :temp_price "96249.56", :lat 0.0, :lon 0.0, :first_time_limit_btc nil, :volume_coefficient_btc "1.50"}, :actions {:public_view "https://localbitcoins.com/ad/62627"}}

user=> (def usd-sell-ads @(get-online-ads {:kind :sell-bitcoins-online :currency "USD"}))
#'user/usd-sell-ads

user=> (:ad_count usd-sell-ads)
50

user=> (first (:ad_list usd-sell-ads))
{:data {:require_feedback_score 0, :visible true, :reference_type "SHORT", :bank_name "", :profile {:username "fernandob", :feedback_score 100, :trade_count "17", :last_online "2014-02-08T16:32:09+00:00", :name "fernandob (17; 100%)"}, :currency "USD", :online_provider "NETELLER", :sms_verification_required false, :max_amount "250", :ad_id 47497, :age_days_coefficient_limit "4.00", :trade_type "ONLINE_BUY", :location_string "Argentina", :min_amount "50", :temp_price_usd "519.46", :city "", :msg "Contact hours: Lun-Vier 9:00 a 18:00\r\n\r\nUna vez iniciado el proceso de scrow, transfiero USD directo a tu cuenta de NETELLER.\r\n\r\nPOR FAVOR EN LA SOLICITUD DE VENTA INCLUIR EL MAIL ASOCIADO A TU CUENTA NETELLER.\r\n\r\nPOR FAVOR: SOLO NETELLER!!!!!\r\n", :created_at "2013-11-27T20:38:39+00:00", :countrycode "AR", :require_trade_volume 0.0, :email nil, :max_amount_available "250", :temp_price "519.46", :lat -38.42, :lon -63.62, :first_time_limit_btc nil, :volume_coefficient_btc "1.50"}, :actions {:public_view "https://localbitcoins.com/ad/47497"}}
```

## License

Copyright © 2014 John P. Hackworth <jph@hackworth.be>

Distributed under the Mozilla Public License Version 2.0
