$(document).ready(function () {
    console.log("jQuery loaded");

    // Fetch all accounts
    $("#fetchAccounts").click(function () {
        $.ajax({
            url: "http://localhost:8080/accounts/all",
            method: "GET",
            success: function (accounts) {
                let rows = "";
                accounts.forEach(account => {
                    rows += `<tr>
                        <td>${account.accountNumber}</td>
                        <td>${account.accountHolder}</td>
                        <td>${account.balance}</td>
                        <td>
                            <button onclick="deleteAccount('${account.accountNumber}')">Delete</button>
                            <button onclick="showTransactionHistory('${account.accountNumber}')">History</button>
                            <button onclick="performTransaction('${account.accountNumber}', 'DEPOSIT')">Deposit</button>
                            <button onclick="performTransaction('${account.accountNumber}', 'WITHDRAW')">Withdraw</button>
                        </td>
                    </tr>`;
                });
                $("#accountsTable").html(rows);
            }
        });
    });

    // Add new account
    $("#addAccount").click(function () {
        let accountData = {
            accountNumber: $("#accountNumber").val(),
            accountHolder: $("#accountHolder").val(),
            balance: $("#balance").val()
        };

        $.ajax({
            url: "http://localhost:8080/accounts/add",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(accountData),
            success: function () {
                alert("Account added successfully!");
                $("#fetchAccounts").click();
            }
        });
    });
});

// Delete account
function deleteAccount(accountNumber) {
    $.ajax({
        url: `http://localhost:8080/accounts/delete/${accountNumber}`,
        method: "DELETE",
        success: function (response) {
            alert(response);
            $("#fetchAccounts").click();
        }
    });
}

// Perform deposit/withdrawal
function performTransaction(accountNumber, type) {
    let amount = prompt(`Enter amount to ${type.toLowerCase()}:`);
    if (!amount) return;

    $.ajax({
        url: `http://localhost:8080/transactions/${accountNumber}/${type}/${amount}`,
        method: "POST",
        success: function (response) {
            alert(response);
            $("#fetchAccounts").click();
        }
    });
}

// Show transaction history
function showTransactionHistory(accountNumber) {
    $.ajax({
        url: `http://localhost:8080/transactions/history/${accountNumber}`,
        method: "GET",
        success: function (transactions) {
            let history = "Transaction History:\n";
            transactions.forEach(tx => {
                history += `Type: ${tx.transactionType}, Amount: ${tx.amount}, Date: ${tx.dateTime}\n`;
            });
            alert(history);
        }
    });
}

// Deposit money
function depositMoney() {
    let accountNumber = $("#depositAccountNumber").val();
    let amount = $("#depositAmount").val();
    $.post(`/transactions/${accountNumber}/DEPOSIT/${amount}`, function (response) {
        alert("Deposit Successful: " + response);
    });
}

// Withdraw money
function withdrawMoney() {
    let accountNumber = $("#withdrawAccountNumber").val();
    let amount = $("#withdrawAmount").val();
    $.post(`/transactions/${accountNumber}/WITHDRAW/${amount}`, function (response) {
        alert("Withdrawal Successful: " + response);
    });
}

// Get transaction history
function getTransactionHistory() {
    let accountNumber = $("#historyAccountNumber").val();
    $.get(`/transactions/history/${accountNumber}`, function (response) {
        $("#historyResult").html(response);
    });
}