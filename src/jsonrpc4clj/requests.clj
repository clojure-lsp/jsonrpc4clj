(ns jsonrpc4clj.requests)

(set! *warn-on-reflection* true)

(defn request [id method params]
  {:jsonrpc "2.0"
   :method method
   :params params
   :id id})

(defn notification [method params]
  {:jsonrpc "2.0"
   :method method
   :params params})
