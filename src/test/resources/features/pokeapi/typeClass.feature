# new feature
# Tags: optional

Feature: Tipos de pokemon
  Como jugador de pokemon
  quiero conocer las debilidades y fortalezas de los diferentes tipos
  para poder realizar estrategias

  Scenario: El tipo de pokemon fuerte
    Given El jugador se encuentra dentro de la pagina adecuada para realizar la consulta
    When El jugador consulta el tipo "rock",para conocer un tipo contra cual es fuerte
    Then El jugador recibe el tipo contra cual es fuerte "flying"

  Scenario: El tipo de pokemon debil
    Given El jugador desea realizar otro tipo de consulta
    When El jugador consulta el tipo "water", para conocer un tipo contra cual es debil
    Then El jugador recibe el tipo contra cual es debil "electric"