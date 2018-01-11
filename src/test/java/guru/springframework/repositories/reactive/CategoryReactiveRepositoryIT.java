package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryIT {

    @Autowired
    CategoryReactiveRepository repo;

    @Test
    public void testDocumentAdded() {

        Category cat1 = new Category();
        cat1.setDescription("desc1");
        cat1.setId("id1");

        repo.save(cat1).block();

        assertThat(repo.count().block()).isEqualTo(1);


        assertThat(repo.findByDescription("desc1").block().getId()).isEqualTo("id1");





    }
}
