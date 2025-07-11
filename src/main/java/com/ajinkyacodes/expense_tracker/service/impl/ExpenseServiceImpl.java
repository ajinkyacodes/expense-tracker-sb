package com.ajinkyacodes.expense_tracker.service.impl;

import com.ajinkyacodes.expense_tracker.dto.ExpenseDto;
import com.ajinkyacodes.expense_tracker.entity.Expense;
import com.ajinkyacodes.expense_tracker.mapper.ExpenseMapper;
import com.ajinkyacodes.expense_tracker.repository.ExpenseRepository;
import com.ajinkyacodes.expense_tracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
        // get expense entity from the database using expense id
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(()-> new RuntimeException("Expense not found with id:"+ expenseId));

        // Convert Expense entity to ExpenseDto
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map((expense) -> ExpenseMapper.mapToExpenseDto(expense)).collect(Collectors.toList());
    }
}
