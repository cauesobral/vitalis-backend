# 🩺 Vitalis – API de Triagem e Agendamento Médico

## Sobre o Projeto

O **Vitalis** é uma aplicação backend desenvolvida para gerenciar o fluxo de **triagem e agendamento de pacientes** em ambientes clínicos e hospitalares.

O sistema permite cadastrar pacientes, realizar agendamentos médicos e organizar o atendimento por meio da **Classificação de Risco de Manchester**, priorizando pacientes conforme o nível de urgência.

Além disso, o sistema considera diferentes modalidades de consulta e permite selecionar a especialidade desejada durante o processo de agendamento.

---

## Funcionalidades

### 👤 Gestão de Pacientes

* Cadastro de pacientes
* Consulta de paciente por ID
* Listagem de pacientes cadastrados

### 📅 Agendamento de Consultas

* Criação de agendamentos
* Escolha da modalidade:

  * Presencial
  * Telemedicina
  * Ambos

### 🚑 Triagem Médica

Classificação baseada no **Protocolo de Manchester**:

| Cor         | Prioridade             |
| ----------- | ---------------------- |
| 🔵 Azul     | Sem prioridade         |
| 🟢 Verde    | Prioridade baixa–média |
| 🟡 Amarelo  | Prioridade média–alta  |
| 🟠 Laranja  | Alta prioridade        |
| 🔴 Vermelho | Atendimento urgente    |

Outras informações consideradas:

* Paciente acompanhado ou desacompanhado
* Especialidade médica desejada

### 🔄 Fluxo do Atendimento

O ciclo do atendimento segue os estados:

1. Agendado
2. Chegada registrada
3. Triagem realizada
4. Em consulta
5. Alta médica

Também é possível realizar cancelamentos.

---

## Tecnologias Utilizadas

### Backend

* Java 17
* Spring Boot

### Banco de Dados

* PostgreSQL

### Arquitetura e Validações

* Spring Data JPA
* Jakarta Validation
* Arquitetura em camadas (Layered Architecture)

---

## Estrutura do Projeto

```plaintext
src/
└── main/
    ├── java/
    │   └── com.cauesobral.vitalis/
    │       ├── controller/
    │       ├── dto/
    │       ├── exception/
    │       ├── model/
    │       ├── repository/
    │       ├── security/
    │       ├── service/
    │       │   └── impl/
    │       ├── util/
    │       └── validation/
    │
    └── resources/
        └── application.properties
```

### Responsabilidade das Pastas

| Pasta      | Responsabilidade               |
| ---------- | ------------------------------ |
| controller | Endpoints da API               |
| dto        | Objetos de entrada e saída     |
| exception  | Tratamento global de exceções  |
| model      | Entidades do domínio           |
| repository | Comunicação com banco de dados |
| service    | Regras de negócio              |
| util       | Classes utilitárias            |
| validation | Regras de validação            |
| security   | Configuração de segurança      |

---

## Endpoints

### Pacientes

#### Criar paciente

```http
POST /api/patients
```

#### Buscar paciente por ID

```http
GET /api/patients/{id}
```

#### Listar pacientes

```http
GET /api/patients
```

---

### Agendamentos

#### Criar agendamento

```http
POST /api/appointments
```

#### Registrar chegada

```http
PATCH /api/appointments/{id}/arrive
```

#### Encaminhar para triagem

```http
PATCH /api/appointments/{id}/triage
```

#### Encaminhar para consulta

```http
PATCH /api/appointments/{id}/consult
```

#### Dar alta ao paciente

```http
PATCH /api/appointments/{id}/discharge
```

#### Cancelar agendamento

```http
PATCH /api/appointments/{id}/cancel
```

---

## Como Executar Localmente

### 1. Clonar o repositório

```bash
git clone <url-do-repositorio>
cd vitalis
```

### 2. Criar o banco PostgreSQL

```sql
CREATE DATABASE vitalis;
```

### 3. Configurar o `application.properties`

```properties
spring.application.name=vitalis

spring.datasource.url=jdbc:postgresql://localhost:5432/vitalis
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 4. Executar o projeto

Linux / macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

Aplicação disponível em:

```plaintext
http://localhost:8080
```

---

## Status Atual

### ✅ Implementado

* Cadastro de pacientes
* Agendamento
* Integração com PostgreSQL
* DTOs
* Validações
* Tratamento de exceções

### 🚧 Em desenvolvimento

* Fluxo completo de triagem
* Módulo médico
* Camada de segurança
* Integração com Front-end React

---

## Melhorias Futuras

* Autenticação JWT
* Documentação com Swagger/OpenAPI
* Docker
* Logs de auditoria
* Sistema de notificações
* Dashboard administrativo
* Visualização de filas por prioridade

---

## Autor

**Cauê Sobral**
Estudante de Ciência da Computação
