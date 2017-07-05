from selenium import webdriver 
from selenium.webdriver.common.keys import Keys
import time

driver = webdriver.Firefox()


driver.maximize_window()
driver.get("http://localhost:8080/login");

elem = driver.find_element_by_xpath("//form[ @class = 'login']/input[ @name = 'username' ]")
elem.send_keys('petros')
elem = driver.find_element_by_xpath("//form[ @class = 'login']/input [ @name = 'password' ]")
elem.send_keys('1234')

time.sleep(4)

elem = driver.find_element_by_xpath("//form [ @class = 'login']/input [ @type = 'submit']")
elem.click()

time.sleep(5)

elem = driver.find_element_by_xpath("//form[ @role= 'search']/input[ @name = 'srch-term']")
elem.send_keys('petros')
elem = driver.find_element_by_xpath("//form[ @role= 'search']/button[ @type= 'submit' ]")
elem.click()

time.sleep(10)

elem = driver.find_element_by_xpath("//label[ @class = 'btn btn-primary toggle-on' ] ")
elem.click()

time.sleep(10)

driver.get("http://localhost:8080/event/4")

elem = driver.find_element_by_xpath("//div [ @class = 'upload']/form/textarea[ @id = 'name'] ")
elem.send_keys('just another activity')

elem = driver.find_element_by_xpath("//div [ @class = 'upload']/form/button")
elem.click()
time.sleep(10)
driver.get("http://localhost:8080/event/4")

elem = driver.find_element_by_xpath("//form[ @id = 'ticket-form' ]/input[ @id = 'qty']")
elem.clear()
elem.send_keys("2")

elem = driver.find_element_by_id("myBtn")
elem.click()

time.sleep(10)
 
elem = driver.find_element_by_xpath("//input[ @form = 'ticket-form' and @class = 'confirm-button' ]")
elem.click()
driver.get("http://localhost:8080/myprofile")
time.sleep(10)

driver.close()
