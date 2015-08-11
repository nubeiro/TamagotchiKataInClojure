(ns tamagotchi.core)

(defn hungriness [tamagotchi]
  (:hungriness @tamagotchi))

(defn fullness [tamagotchi]
  (:fullness @tamagotchi))

(defn tiredness [tamagotchi]
  (:tiredness @tamagotchi))

(def default-fullness 0)

(def default-hungriness 2)

(def default-tiredness 0)

(defn make-tamagotchi
  [& {:keys [hungriness fullness tiredness]
      :or {hungriness default-hungriness
           fullness default-fullness
           tiredness default-tiredness}}]
  (atom {:hungriness hungriness
         :fullness fullness
         :tiredness tiredness}))

(defn- change [tamagotchi key value]
  (swap! tamagotchi assoc key value))

(defn- decrease-hungriness [tamagotchi]
  (change tamagotchi :hungriness (dec (hungriness tamagotchi))))

(defn- increase-fullness [tamagotchi]
  (change tamagotchi :fullness (inc (fullness tamagotchi))))

(defn- decrease-tiredness [tamagotchi]
  (change tamagotchi :tiredness (dec (tiredness tamagotchi))))

(defn feed [tamagotchi]
  (do (decrease-hungriness tamagotchi)
      (increase-fullness tamagotchi)))

(defn go-to-bed [tamagotchi]
  (decrease-tiredness tamagotchi))