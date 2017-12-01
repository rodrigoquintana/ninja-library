package es.codemotion.madrid.library.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import es.codemotion.madrid.library.dao.Item;
import es.codemotion.madrid.library.repositories.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CatalogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testBorrowMethod() throws Exception{

        when(bookRepository.findOne(12345l)).thenReturn(new Item("nombre","autor","desc",9,true,""));
        this.mockMvc.perform(get("/catalog/borrow?bookId=12345")).andExpect(status().is3xxRedirection());
    }


}
