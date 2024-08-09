# Basic Credit Card Processing

## Overview

This repository contains a program for basic credit card processing. It allows you to add new credit card accounts, process charges and credits, and generate summary information. The program is designed to handle operations efficiently while ensuring data integrity through Luhn 10 validation.

## Requirements

- **Input Sources:**  
  The program accepts input from both a file passed via command line arguments and STDIN.
    - Example:
        - `./myprogram input.txt`
        - `./myprogram < input.txt`

- **Input Commands:**  
  The program accepts three types of commands, each with space-delimited arguments:
    - **Add**  
      Creates a new credit card account.
        - **Arguments:** Name, Card Number, Credit Limit.
        - **Validation:** Card number must pass Luhn 10 validation.
        - **Initial Balance:** $0.
    - **Charge**  
      Increases the card balance by the specified amount.
        - **Constraints:** Charges that exceed the credit limit are ignored. Charges against invalid cards are ignored.
    - **Credit**  
      Decreases the card balance by the specified amount.
        - **Constraints:** Credits that drop the balance below $0 result in a negative balance. Credits against invalid cards are ignored.

- **Output:**  
  Once all commands are processed, the program outputs a summary to STDOUT, listing each account holder’s name alphabetically, followed by the account balance. If the card number is invalid, "error" is displayed instead of the balance.

## Assumptions

- All input is valid (no illegal characters or malformed commands).
- Each name will have only one associated credit card.
- All input is space-delimited.
- Credit card numbers are numeric and up to 19 characters in length.
- Amounts are in whole dollars prefixed with "$".

## Example

Given the following input:

```
Add Tom 4111111111111111 $1000
Add Lisa 5454545454545454 $3000
Add Quincy 1234567890123456 $2000
Charge Tom $500
Charge Tom $800
Charge Lisa $7
Credit Lisa $100
Credit Quincy $200
```

The expected output is:

```
Lisa: $-93
Quincy: error
Tom: $500
```

## Implementation

- You can implement the solution in any programming language.
- Ensure the code is correct and well-tested.
- You may use an external library for Luhn 10 validation or implement your own.

## Testing

- Automated tests should be written and included in the repository.
- Tests should verify the correctness of each command and the final output.

---

This README provides a clear and concise guide to the repository, ensuring that users understand the functionality, requirements, and expected behavior of the credit card processing program.