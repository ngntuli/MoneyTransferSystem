# Internal Money Transfer System
Our task is to automate a business process associated with transfers of certain
amounts between participants of our system.

Each system user can transfer a certain amount to another user.
Inside the system, all money transactions are stored in the form of debit/credit pairs.

For example, John has transferred \R500 to Mike. System saves the transaction for both
users:
######John -> Mike, -500, OUTCOME, transaction ID
######Mike -> John, +500, INCOME, transaction ID
To recover the connection within such pairs, identifiers of each transaction should be
used.

##Demo

1. Loading Data...

2. Starting Application...

------------------------------------------------------------------
1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. EXIT

#####1
Enter a user name and a balance

#####Jonh 777
User with id = 5 is added

------------------------------------------------------------------
1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. EXIT

#####1
Enter a user name and a balance

#####Mike 100
User with id = 6 is added

------------------------------------------------------------------
1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. EXIT

#####3

Enter a sender ID, a recipient ID, and a transfer amount

#####5 6 100
The transfer is completed

------------------------------------------------------------------
1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. EXIT

#####3
Enter a sender ID, a recipient ID, and a transfer amount

#####5 6 150
The transfer is completed

------------------------------------------------------------------
1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. EXIT

#####3
Enter a sender ID, a recipient ID, and a transfer amount

#####5 6 50
The transfer is completed

------------------------------------------------------------------
1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. EXIT

#####4
Enter a user ID

#####5
To Mike(id = 6) -100 with id = 0eb1a1c8-ac84-4b9b-8f57-3463bcd36eab

To Mike(id = 6) -150 with id = 0d0c39e7-d611-4301-a877-f3fac751cce6

To Mike(id = 6) -50 with id = 96adeb58-8e9b-4d0c-aeaf-d62a1fa9e534

------------------------------------------------------------------
1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. EXIT

#####4
Enter a user ID

#####6
From Jonh(id = 5) +100 with id = 0eb1a1c8-ac84-4b9b-8f57-3463bcd36eab

From Jonh(id = 5) +150 with id = 0d0c39e7-d611-4301-a877-f3fac751cce6

From Jonh(id = 5) +50 with id = 96adeb58-8e9b-4d0c-aeaf-d62a1fa9e534

------------------------------------------------------------------
1. Add a user
2. View user balances
3. Perform a transfer
4. View all transactions for a specific user
5. EXIT

#####5
Good bye!
