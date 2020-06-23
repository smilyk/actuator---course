# actuator---course
= !!! = !!! = !!! = !!! = !!! = !!! = !!!
learning spring boot actuator
= !!! = !!! = !!! = !!! = !!! = !!! = !!!

info about git -> http://localhost:8080/info

metrix ->

    - позволяет увидеть что происходит в приложении
    - сколько запросов
    - что приходит
    - что уходит и тд
    
приводит метрики в вид JSON для удобства чтения


    -spring.jackson.serialization.indent_output=true
    
http://localhost:8080/trace - показывает заголовки запросов и другую info, нужную для анализа работы приожения

<artifactId>spring-boot-starter-remote-shell</artifactId>

    - Using default password for shell access: ab43495b-3f56-4dba-b0b8-7748fa9fa787 дает пароль для Shell
    - In terminal:
        - ssh -p 2000 user@localhost  разрешить - должен попросить пароль
        
#

    - system -help
    - endpoint list // покажет все конечные точки актуатора
    - endpoint invoke metricsEndpoint //получить данные конкретной API
    