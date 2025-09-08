package in.project.expensetracker;

import in.project.expensetracker.model.Expense;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExpenseControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createAndFetchExpense() {
        String base = "http://localhost:" + port + "/api/expenses";

        Expense e = Expense.builder()
                .title("Test Lunch")
                .amount(new BigDecimal("123.45"))
                .category("Food")
                .date(LocalDate.now())
                .build();

        ResponseEntity<Expense> createResp = restTemplate.postForEntity(base, e, Expense.class);
        assertThat(createResp.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Long id = createResp.getBody().getId();
        assertThat(id).isNotNull();

        Expense fetched = restTemplate.getForObject(base + "/" + id, Expense.class);
        assertThat(fetched.getTitle()).isEqualTo("Test Lunch");
    }
}
