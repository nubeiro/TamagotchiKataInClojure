(ns tamagotchi.core-test
  (:use midje.sweet)
  (:use [tamagotchi.core]))

(facts
  "about Tamagotchi"

  (facts
    "when it is created"

    (fact
      "it has some default values"
      (let [tamagotchi (make-tamagotchi)]
        (hungriness tamagotchi) => default-hungriness
        (fullness tamagotchi) => default-fullness
        (tiredness tamagotchi) => default-tiredness
        (happiness tamagotchi) => default-happiness))

    (fact
      "or the ones you initializes it with"
      (let [tamagotchi
            (make-tamagotchi
              :fullness 3 :hungriness 4 :tiredness 5 :happiness 10)]
        (hungriness tamagotchi) => 4
        (fullness tamagotchi) => 3
        (tiredness tamagotchi) => 5
        (happiness tamagotchi) => 10)))

  (facts
    "when it is fed"

    (fact
      "its hungriness decreases by one"
      (let [tamagotchi (make-tamagotchi :hungriness 5)]

        (feed tamagotchi)

        (hungriness tamagotchi) => 4))

    (fact
      "its fullness increases by one"
      (let [tamagotchi (make-tamagotchi :fullness 10)]

        (feed tamagotchi)

        (fullness tamagotchi) => 11)))

  (facts
    "when it goes to bed"

    (fact
      "its tiredness decreases by one"
      (let [tamagotchi (make-tamagotchi :tiredness 10)]

        (go-to-bed tamagotchi)

        (tiredness tamagotchi) => 9)))

  (facts
    "when I play with it"

    (fact
      "its happiness increases by one"

      (let [tamagotchi (make-tamagotchi :happiness 20)]

        (play-with tamagotchi)

        (happiness tamagotchi) => 21))

    (fact
      "its tiredness increases by one"

      (let [tamagotchi (make-tamagotchi :tiredness 10)]

        (play-with tamagotchi)

        (tiredness tamagotchi) => 11)))

  (facts
    "when it makes poo"

    (fact
      "its fullness decreases"
      (let [tamagotchi (make-tamagotchi :fullness 4)]

        (make-loads-of-poo tamagotchi)

        (fullness tamagotchi) => 3)))

  )
