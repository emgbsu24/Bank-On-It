# Bank-On-It
Part 1

``` mermaid
classDiagram

class HasMenu {
    +menu() String
    +start() void
}

class User {
    -userName : String
    -PIN : String
    +login() boolean
    +login(userName, PIN) boolean
    +setUserName(userName) void
    +getUserName() String
    +setPIN(PIN) void
    +getPIN() String
    +getReport() String
}

class Admin {
    +Admin()
    +menu() String
    +getReport() String
}

class Customer {
    -checking : CheckingAccount
    -savings : SavingsAccount
    +Customer()
    +start() void
    +menu() String
    +changePIN() void
    +getReport() String
}

class CheckingAccount {
    -balance : double
    +CheckingAccount()
    +CheckingAccount(balance)
    +menu() String
    +start() String
    +getBalance() double
    +getBalanceString() String
    +setBalance(balance) void
    +checkBalance() void
    +makeDeposit() void
    +makeWithdrawal() void
}

class SavingsAccount {
    -interestRate : double
    +calcInterest() void
    +setInterestRate() void
    +getInterestRate() double
}

class Bank {
    -admin : Admin
    -customers : ArrayList
    +Bank()
    +main() void
    +loadSampleCustomers() void
    +loadCustomers() void
    +saveCustomers() void
    +fullCustomerReport() void
    +addUser() void
    +applyInterest() void
    +loginAsCustomer() void
    +menu() void
    +start() void
    +startAdmin() void
}

User <|-- Admin
HasMenu <|.. User

CheckingAccount <|-- SavingsAccount

HasMenu <|.. CheckingAccount
User <|-- Customer

Bank --> Admin
Bank --> Customer
```
