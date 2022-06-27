#Hence, for Java 11, we will need to add the JAXB dependencies - API and an implementation. 
# após criar o arquibo .xsd e colocar na pasta resources/xsd,
# rode o comando: mvn clean compile, em um terminal na raiz do projeto

# comando para gerar as classes do cliente: xjc -wsdl  http://localhost:8080/ws/customers.wsdl -p com.ejs.serviceWSDL 
# ou wsimport -s serviceWSDL -p br.com.ejs http://localhost:8080/ws/customers.wsdl 
# onde -s opção do comando que indica a pasta onde as classes vão ser criadas, neste caso criou-se dentro da pasta serviceWsdl
# a opção -p nomepacote indica o nome do pacote onde as classes serão criadas, neste caso br.com.ejs, assim sendo temos uma pasta
# com o nome serviceWSDL, dentro dela o pacote br.com.ejs com as classes java
# para rodar o comando acima rode primeiro este Comando para instalar a ferramenta: sudo apt install jaxws
# rode o comando acima dentro da pasta que terá as classes no cliente 
# o serviço deve ser estar up

