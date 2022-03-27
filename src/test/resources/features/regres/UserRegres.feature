# new feature
# Tags: optional

Feature: Datos de usuarios
  Como usuario de la pagina
  quiero realizar y consultar datos de usuarios
  para poder verificar la base de datos

  Scenario: Validar un usuario existente
    Given se necesita verificar la existencia del usuario con id = <numId>
    When el cliente recibe la informacion solicitada si se encuentra



  Scenario: Actualizar un usuario
    Given un cliente previamente registrado desea actualizar los datos
    When cliente ingresa el nombre "morpheus", para actualizar
    Then cliente ingresa los datos a actualizar