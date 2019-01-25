package arevilla.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import arevilla.web.controler.CodeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeTests {
 
	@Autowired
    private CodeController codeController;
 
	@MockBean
    private CodeService codeService;
    
    @Test
    public void contexLoads() throws Exception {
        assertThat(codeController).isNotNull();
    }
	 
}
