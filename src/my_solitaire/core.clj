(ns my-solitaire.core
  (:gen-class))


;; card
;; (card/make :diamonds :2)

;; stack
;; {:down (list card) :up (list card)}

;; game
;; {:foundations [stack x4]
;;  :stock       [stack x1]
;;  :tableau     [stack x7]}

;; move
;; (fn [game] ... new-game)


(defn- move-fn [count from to transform]
  (fn [game]
    (let [cards (take count (get-in game from))]
      (-> game
          (update-in from (partial drop count))
          (update-in to into (transform cards))))))

(defn flip-fn [count from to]
  (move-fn count from to identity))

(defn transfer-fn [count from to]
  (move-fn count from to reverse))








(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
