@startuml

state  0
state  1
state  2
state  3
state  4

0 --> 1: buy
1 --> 2: sell
2 --> 3: buy
3 --> 4: sell

0 --> 0: rest
1 --> 1: rest
2 --> 2: rest
3 --> 3: rest

@enduml