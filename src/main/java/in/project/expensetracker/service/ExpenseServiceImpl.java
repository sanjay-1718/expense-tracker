package in.project.expensetracker.service;

import in.project.expensetracker.exception.ResourceNotFoundException;
import in.project.expensetracker.model.Expense;
import in.project.expensetracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    @Override
    public Expense create(Expense e) {
        e.setId(null);
        return repository.save(e);
    }

    @Override
    public List<Expense> findAll() {
        return repository.findAll();
    }

    @Override
    public Expense findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Expense not found with id " + id));
    }

    @Override
    public Expense update(Long id, Expense e) {
        Expense existing = findById(id);
        existing.setTitle(e.getTitle());
        existing.setAmount(e.getAmount());
        existing.setCategory(e.getCategory());
        existing.setDate(e.getDate());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Expense not found with id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<Expense> findByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category);
    }

    @Override
    public List<Expense> findByDateRange(LocalDate start, LocalDate end) {
        return repository.findByDateBetween(start, end);
    }
}
