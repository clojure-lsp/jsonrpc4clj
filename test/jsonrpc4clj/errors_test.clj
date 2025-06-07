(ns jsonrpc4clj.errors-test
  (:require
   [clojure.test :refer [deftest is]]
   [jsonrpc4clj.errors :as errors]))

(deftest body-should-look-up-error-by-code
  ;; Uses known code and message
  (is (= {:code -32001
          :message "Unknown error"}
         (errors/body :unknown-error-code nil nil)))
  ;; Prefers custom message with known code
  (is (= {:code -32001
          :message "Custom message"}
         (errors/body :unknown-error-code "Custom message" nil)))
  ;; Uses custom code
  (is (= {:code -1}
         (errors/body -1 nil nil)))
  ;; Uses custom code and message
  (is (= {:code -1
          :message "Custom message"}
         (errors/body -1 "Custom message" nil)))
  ;; Uses custom code, message, and data
  (is (= {:code -1
          :message "Custom message"
          :data {:details "error"}}
         (errors/body -1 "Custom message" {:details "error"}))))
