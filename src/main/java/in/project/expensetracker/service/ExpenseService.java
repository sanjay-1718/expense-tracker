package in.project.expensetracker.service;

import in.project.expensetracker.model.Expense;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {
    Expense create(Expense e);
    List<Expense> findAll();
    Expense findById(Long id);
    Expense update(Long id, Expense e);
    void delete(Long id);
    List<Expense> findByCategory(String category);
    List<Expense> findByDateRange(LocalDate start, LocalDate end);
}
