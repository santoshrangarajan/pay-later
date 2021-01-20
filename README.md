# pay-later
Pay Later Concept

As a pay later service we allow our users to buy goods from a merchant now, and then allow them to pay for those goods at a later date.
The service works inside the boundary of following simple constraints - \

Let's say that for every transaction paid through us, merchants offer us a discount.\
  ○ For example, if the transaction amount is Rs.100, and merchant discount offered to us is 10%, we pay Rs. 90 back to the merchant.\
  ○ The discount varies from merchant to merchant. \
  ○ A merchant can decide to change the discount it offers to us, at any point in time. \
  
All users get onboarded with a credit limit, beyond which they can't transact. \
  ○ If a transaction value crosses this credit limit, we reject the transaction.\


Use Cases\
There are various use cases our service is intended to fulfil -\
● allow merchants to be onboarded with the amount of discounts they offer\
● allow merchants to change the discount they offer \
● allow users to be onboarded (name, email-id and credit-limit) \
● allow a user to carry out a transaction of some amount with a merchant. \
● allow a user to pay back their dues (full or partial)\
● Reporting: \
    ○ how much discount we received from a merchant till date \
    ○ dues for a user so far \
    ○ which users have reached their credit limit \
    ○ total dues from all users together\

CLI \
here is how the command line interface, corresponding to the use-cases mentioned above, can look like -\

new user u1 u1@email.in 1000 \
new merchant m1 2% \
new txn u1 m2 400 \
update merchant m1 1% \  
payback u1 300 \
report discount m1 \
report dues u1 \
report users-at-credit-limit \ 
report total-dues \
