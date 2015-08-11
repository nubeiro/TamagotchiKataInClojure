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

(defn- decrease-hungriness [tamagotchi]
  (swap! tamagotchi assoc :hungriness (dec (hungriness tamagotchi))))

(defn- increase-fullness [tamagotchi]
  (swap! tamagotchi assoc :fullness (inc (fullness tamagotchi))))

(defn feed [tamagotchi]
  (do (decrease-hungriness tamagotchi)
      (increase-fullness tamagotchi)))

(defn go-to-bed [tamagotchi]
  (swap! tamagotchi assoc :tiredness (dec (tiredness tamagotchi))))