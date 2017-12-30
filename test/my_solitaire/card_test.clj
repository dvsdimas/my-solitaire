(ns my-solitaire.card-test
  (:require [clojure.test :refer :all]
            [my-solitaire.card :as card]))

(deftest card-test

  (testing "card/make"
    (is (= (card/make :diamonds :A) [:diamonds :A]))
    (is (= (card/make :clubs :9) [:clubs :9]))
    (is (not= (card/make :diamonds :A) [:clubs :A]))
    (is (not= (card/make :clubs :A) [:clubs :K])))

  (testing "card/suit"
    (is (= (card/suit (card/make :diamonds :K)) :diamonds))
    (is (= (card/suit (card/make :hearts :Q)) :hearts))
    (is (= (card/suit (card/make :clubs :J)) :clubs))
    (is (= (card/suit (card/make :spades :10)) :spades)))

  (testing "card/value"
    (is (= (card/value (card/make :diamonds :A))  :A))
    (is (= (card/value (card/make :hearts   :2))  :2))
    (is (= (card/value (card/make :spades   :3))  :3))
    (is (= (card/value (card/make :clubs    :4))  :4))
    (is (= (card/value (card/make :hearts   :5))  :5))
    (is (= (card/value (card/make :spades   :6))  :6))
    (is (= (card/value (card/make :clubs    :7))  :7))
    (is (= (card/value (card/make :diamonds :8))  :8))
    (is (= (card/value (card/make :hearts   :9))  :9))
    (is (= (card/value (card/make :spades   :10)) :10))
    (is (= (card/value (card/make :clubs    :J))  :J))
    (is (= (card/value (card/make :diamonds :Q))  :Q))
    (is (= (card/value (card/make :hearts   :K))  :K)))

  (testing "card/suit-color"
    (is (= (card/suit-color :diamonds) :red))
    (is (= (card/suit-color :hearts)   :red))
    (is (= (card/suit-color :spades)   :black))
    (is (= (card/suit-color :clubs)    :black))

    (is (= :black
           (-> (card/make :clubs :7)
               (card/suit)
               (card/suit-color))))

    (is (= :red
           (-> (card/make :hearts :Q)
               (card/suit)
               (card/suit-color))))

    (is (= :red
           (-> (card/make :diamonds :4)
               (card/color))))

    (is (= :black
           (-> (card/make :spades :2)
               (card/color)))))

  (testing "card/value-to-numeric"
    (is (= 1
          (-> (card/make :spades :A)
              (card/value)
              (card/value-to-numeric))))
    (is (= 8
           (-> (card/make :hearts :8)
               (card/value)
               (card/value-to-numeric))))
    (is (= 13
           (-> (card/make :diamonds :K)
               (card/value)
               (card/value-to-numeric))))))
