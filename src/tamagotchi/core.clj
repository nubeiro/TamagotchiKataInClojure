(ns tamagotchi.core)

(defn hungriness [tamagotchi]
  (:hungriness @tamagotchi))

(defn fullness [tamagotchi]
  (:fullness @tamagotchi))

(defn tiredness [tamagotchi]
  (:tiredness @tamagotchi))

(defn happiness [tamagotchi]
  (:happiness @tamagotchi))

(def default-fullness 0)

(def default-hungriness 2)

(def default-tiredness 0)

(def default-happiness 20)

(defn make-tamagotchi
  [& {:keys [hungriness fullness tiredness happiness]
      :or   {hungriness default-hungriness
             fullness   default-fullness
             tiredness  default-tiredness
             happiness default-happiness}}]
  (atom {:hungriness hungriness
         :fullness   fullness
         :tiredness  tiredness
         :happiness  happiness}))

(defn- change [tamagotchi key value]
  (swap! tamagotchi assoc key value))

(defn- decrease [attribute tamagotchi]
  (change tamagotchi attribute (dec (attribute @tamagotchi))))

(defn- increase [attribute tamagotchi]
  (change tamagotchi attribute (inc (attribute @tamagotchi))))

(defn feed [tamagotchi]
  (decrease :hungriness tamagotchi)
  (increase :fullness tamagotchi))

(defn go-to-bed [tamagotchi]
  (decrease :tiredness tamagotchi))

(defn play-with [tamagotchi]
  (increase :happiness tamagotchi)
  (increase :tiredness tamagotchi))

(defn make-loads-of-poo [tamagotchi]
  (decrease :fullness tamagotchi))