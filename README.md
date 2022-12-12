# horseRacing
```mermaid
classDiagram
    class Cheval {
        <<abstract>>
        -String nomCheval
        -int numeroCheval
        -int nombreVictoire
        -double coteCheval
        -enum sexeCheval
        -enum vitesseCheval
        +calculNote() String
    }
    class Frisson {
        +Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, vitesseCheval)
        +calculNote() String
    }
   class PurSangArabe {
        +PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, vitesseCheval)
        +calculNote() String
    }
    class Mustang {
        +Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, vitesseCheval)
        +calculNote() String
    }
    class PaintHorse {
        +PaintHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, vitesseCheval)
        +calculNote() String
    }
    class QuarterHorse {
        +QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, vitesseCheval)
        +calculNote() String
    }

    class ChevalFactory {
        <<interface>>
        +createCheval() cheval
    }
    class PaintHorseFactory {
        <<interface>>
        +createCheval() PaintHorse
    }
    class QuarterHorseFactory{
        <<interface>>
        +createCheval() QuarterHorse
    }
    class PurSangArabeFactory {
        <<interface>>
        +createCheval() PurSangArabe
    }
    class FrissonFactory {
        <<interface>>
        +createCheval() Frisson
    }
    
   class MustangFactory {
        <<interface>>
        +createCheval() Mustang
    }
    
   class Ecurie {
        +createChevalTresLent(ChevalFactory) Cheval
        +createChevalLent(ChevalFactory) Cheval
        +createChevalMoyen(ChevalFactory) Cheval
        +createChevalRapide(ChevalFactory) Cheval
        +createChevalTresRapide(ChevalFactory) Cheval
    }
 
    Cheval <|-- Frisson
    Cheval <|-- PurSangArabe
    Cheval <|-- Mustang
    Cheval <|-- PaintHorse
    Cheval <|-- QuarterHorse
    
    ChevalFactory <.. PaintHorseFactory
    ChevalFactory <.. QuarterHorseFactory
    ChevalFactory <.. FrissonFactory
    ChevalFactory <.. PurSangArabeFactory
    ChevalFactory <.. MustangFactory
```
