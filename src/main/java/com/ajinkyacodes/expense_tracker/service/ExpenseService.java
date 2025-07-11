package com.ajinkyacodes.expense_tracker.service;

import com.ajinkyacodes.expense_tracker.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {
    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto getExpenseById(Long expenseId);
    List<ExpenseDto> getAllExpenses();
    ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto);
}
