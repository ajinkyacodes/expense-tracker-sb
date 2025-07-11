package com.ajinkyacodes.expense_tracker.service.impl;

import com.ajinkyacodes.expense_tracker.dto.ExpenseDto;
import com.ajinkyacodes.expense_tracker.entity.Category;
import com.ajinkyacodes.expense_tracker.entity.Expense;
import com.ajinkyacodes.expense_tracker.mapper.ExpenseMapper;
import com.ajinkyacodes.expense_tracker.repository.CategoryRepository;
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
    private CategoryRepository categoryRepository;

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

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(()-> new RuntimeException("Expense not found with id:"+ expenseId));

        // Update expense amount
        expense.setAmount(expenseDto.amount());

        // update expense date
        expense.setExpenseDate(expenseDto.expenseDate());

        // update category
        if(expenseDto.categoryDto() != null) {
            // get the category entity by id
            Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(()-> new RuntimeException("Category not found with id: "+expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }

        // update expense entity into database
        Expense updatedExpense = expenseRepository.save(expense);

        // convert expense entity to expenseDto
        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }
}
