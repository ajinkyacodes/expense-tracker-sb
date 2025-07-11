package com.ajinkyacodes.expense_tracker.service;

import com.ajinkyacodes.expense_tracker.dto.ExpenseDto;

public interface ExpenseService {
    ExpenseDto createExpense(ExpenseDto expenseDto);
}
