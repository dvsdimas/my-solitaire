(ns my-solitaire.recursion)


(def ln-nill nil)
(def ln-0 ())
(def ln-1 '(3))
(def ln-10 (range 10))

(count (range 10))

(defn my-length [coll]
  (if (empty? coll)
    0
    (+ 1 (my-length (rest coll)))))


(my-length ln-nill)
(my-length ln-0)
(my-length ln-1)
(my-length ln-10)

(defn- my-length-recur-helper [coll acc]
  (if (empty? coll)
    acc
    (recur (rest coll) (inc acc))))

(defn my-length-recur [coll]
  (my-length-recur-helper coll 0))

(my-length-recur ln-nill)
(my-length-recur ln-0)
(my-length-recur ln-1)
(my-length-recur ln-10)


(defn my-map [f coll]
  (if (empty? coll)
    ()
    (cons (f (first coll))
          (my-map f (rest coll)))))

(my-map inc nil)
(my-map inc [])
(my-map inc (range 10))
(my-map str (range 10))


(defn my-filter [p? coll]
  (lazy-seq
    (if (empty? coll)
      ()
      (if (p? (first coll))
        (cons (first coll) (my-filter p? (rest coll)))
        (my-filter p? (rest coll))))))

(my-filter even? (range))

(my-filter (complement zero?) (range 3))

(defn my-filter-recur [p? coll]
  (loop [coll coll acc []]
    (if (empty? coll)
      acc
      (if (p? (first coll))
        (recur (rest coll) (conj acc (first coll)))
        (recur (rest coll) acc)))))


(my-filter-recur zero? (range 3))
(my-filter-recur nil? (range 3))
(my-filter-recur (complement nil?) (range 3))
(my-filter nil? (range 100000))
(my-filter-recur nil? (range 1000000))


(defn my-map-recur [f coll]
  (loop [coll coll acc []]
    (if (empty? coll)
      acc
      (recur (rest coll) (conj acc (f (first coll)))))))


(my-map-recur inc nil)
(my-map-recur inc [])
(my-map-recur inc (range 10))
(my-map-recur str (range 10))