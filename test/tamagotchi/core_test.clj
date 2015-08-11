(ns tamagotchi.core-test
  (:use midje.sweet)
  (:use [tamagotchi.core]))

(facts
  "about Tamagotchi"

  (facts
    "when created"

    (fact
      "it has some default values"
      (let [tamagotchi (make-tamagotchi)]
        (hungriness tamagotchi) => default-hungriness
        (fullness tamagotchi) => default-fullness
        (tiredness tamagotchi) => default-tiredness))

    (fact
      "or the ones you initializes it with"
      (let [tamagotchi
            (make-tamagotchi
              :fullness 3 :hungriness 4 :tiredness 5)]
        (hungriness tamagotchi) => 4
        (fullness tamagotchi) => 3
        (tiredness tamagotchi) => 5)))

  (facts
    "when is fed"

    (fact
      "its hungriness decreases by one and its fullness increases by one"
      (let [tamagotchi (make-tamagotchi :hungriness 5 :fullness 10)]

        (feed tamagotchi)

        (hungriness tamagotchi) => 4
        (fullness tamagotchi) => 11)))

  (facts
    "when goes to bed"

    (fact
      "its tiredness decreases by one"
      (let [tamagotchi (make-tamagotchi :tiredness 10)]

        (go-to-bed tamagotchi)

        (tiredness tamagotchi) => 9)))

  )
