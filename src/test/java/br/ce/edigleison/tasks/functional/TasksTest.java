package br.ce.edigleison.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TasksTest {
	
	public WebDriver acessarAplicacao() {
    System.setProperty("webdriver.chrome.driver","/opt/chromedriver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		//Abrir Página
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		
		WebDriver driver = acessarAplicacao();
		try {
		
			//Clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			
			//Escrever descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium 4");
			
			//Escrever Data
			driver.findElement(By.id("dueDate")).sendKeys("13/10/2020");
			
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar menssagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);			
		} finally {
			//Fechar o Browser
			driver.quit();
		}
		
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		
		WebDriver driver = acessarAplicacao();
		try {
		
			//Clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever Data
			driver.findElement(By.id("dueDate")).sendKeys("13/10/2020");
			
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar menssagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);			
		} finally {
			//Fechar o Browser
			driver.quit();
		}
		
	}
	
	@Test
	public void NaoDeveSalvarTarefaSemData() {
		
		WebDriver driver = acessarAplicacao();
		try {
		
			//Clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			//Escrever descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium 4");
			
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar menssagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);			
		} finally {
			//Fechar o Browser
			driver.quit();
		}
		
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		
		WebDriver driver = acessarAplicacao();
		try {
		
			//Clicar em add Todo
			driver.findElement(By.id("addTodo")).click();
			
			
			//Escrever descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium 4");
			
			//Escrever Data
			driver.findElement(By.id("dueDate")).sendKeys("13/10/2010");
			
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar menssagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);			
		} finally {
			//Fechar o Browser
			driver.quit();
		}
		
	}

}
