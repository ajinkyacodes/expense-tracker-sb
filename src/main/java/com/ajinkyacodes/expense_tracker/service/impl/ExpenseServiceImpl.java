package com.ajinkyacodes.expense_tracker.service.impl;

import com.ajinkyacodes.expense_tracker.dto.ExpenseDto;
import com.ajinkyacodes.expense_tracker.entity.Expense;
import com.ajinkyacodes.expense_tracker.mapper.ExpenseMapper;
import com.ajinkyacodes.expense_tracker.repository.ExpenseRepository;
import com.ajinkyacodes.expense_tracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    // inject ExpenseRepository using constructor based DI
    private ExpenseRepository expenseRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        // Convert ExpenseDto to Expense entity
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        // Save Expense entity to database
        Expense savedExpense = expenseRepository.save(expense);

        // Convert saved expense entity into ExpenseDto
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }
}
