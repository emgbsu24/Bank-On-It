# Bank-On-It
Part 1


```  mermaid
classDiagram
class HasMenu {
    <<interface>>
    +menu() String
    +start() void
}

class CheckingAccount {
    -double balance
    +CheckingAccount()
    +CheckingAccount(double)
    +menu() String
    +start() void
    +getBalance() double
    +getBalanceString() String
    +setBalance(double) void
    +checkBalance() void
    -getDouble() double
    +makeDeposit() void
    +makeWithdrawal() void
}

class SavingsAccount {
    -double interestRate
    +calcInterest() void
    +setInterestRate(double) void
    +getInterestRate() double
}

class User {
    <<abstract>>
    -String userName
    -String PIN
    +login() boolean
    +login(String, String) boolean
    +setUserName(String) void
    +getUserName() String
    +setPIN(String) void
    +getPIN() String
    +getReport() String*
}

class Customer {
    -CheckingAccount checking
    -SavingsAccount savings
    +Customer()
    +Customer(String, String)
    +menu() String
    +start() void
    +changePin() void
    +getReport() String
}

HasMenu <|.. CheckingAccount
HasMenu <|.. User
CheckingAccount <|-- SavingsAccount
User <|-- Customer
Customer --> CheckingAccount
Customer --> SavingsAccount
```
