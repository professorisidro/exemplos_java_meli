import os
import json
import random

# Recriando a pasta para salvar os arquivos JSON
json_folder_path = '/mnt/data/prontuarios_json'
os.makedirs(json_folder_path, exist_ok=True)

# Listas de nomes, diagnósticos, descrições, e tratamentos
nomes = [
    "João Silva", "Maria Oliveira", "Pedro Souza", "Ana Pereira", "Carlos Lima",
    "Fernanda Gomes", "Ricardo Santos", "Patrícia Almeida", "Roberto Carvalho", 
    "Juliana Costa", "Gabriel Barbosa", "Renata Silva", "Lucas Alves", 
    "Bruna Melo", "André Rocha", "Lúcia Ribeiro", "Marcelo Lima", 
    "Fabiana Teixeira", "Rafael Martins", "Mariana Costa", "Thiago Azevedo", 
    "Isabela Souza", "Fernando Pires", "Cristina Borges", "Vitor Nunes", 
    "Letícia Freitas", "Daniel Fernandes", "Bianca Lima", "Rodrigo Mendes", 
    "Vanessa Cunha", "Leandro Martins", "Paula Dias", "Alexandre Barbosa", 
    "Flávia Almeida", "Júlio César", "Tatiana Oliveira", "Caio Cardoso", 
    "Priscila Ferreira", "Gustavo Santos", "Carolina Matos", "Bruno Moreira"
]

diagnosticos = [
    "Hipertensão", "Diabetes Tipo 2", "Asma", "Depressão", "Colesterol Alto",
    "Hipotireoidismo", "Enxaqueca", "Artrite Reumatoide", "Insônia", "Anemia",
    "Gastrite", "Bronquite", "Hérnia de Disco", "Rinite Alérgica", "Ansiedade",
    "Osteoporose", "Hepatite B", "Dermatite Atópica", "Hipoglicemia", 
    "Cálculo Renal", "Sinusite", "Hipertireoidismo", "Gota", "Depressão Pós-Parto",
    "Infecção Urinária", "Alergia Alimentar", "Distúrbio do Sono", "Acne", 
    "Varizes", "Conjuntivite", "Esquizofrenia", "Candidíase", "Psoríase", 
    "Obesidade", "Doença de Alzheimer", "Vitiligo", "Síndrome do Intestino Irritável", 
    "Cisto Ovariano", "Artrite Psoriática", "Endometriose", "Fibromialgia"
]

descricoes = [
    "Paciente apresenta sintomas clássicos da condição.", 
    "Recomendado tratamento padrão com medicação e acompanhamento.", 
    "Paciente em acompanhamento regular.", 
    "Iniciado novo protocolo de tratamento com acompanhamento especializado.", 
    "Recomendado ajustes na dieta e exercícios físicos regulares.", 
    "Paciente responde bem ao tratamento, manter monitoramento.",
    "Caso requer atenção especial devido a complicações.", 
    "Seguimento clínico contínuo necessário para avaliação.",
    "Paciente com boa evolução após tratamento inicial.",
    "Recomendado evitar fatores de risco conhecidos."
]

tratamentos = [
    "Uso de medicação diária", "Fisioterapia", "Psicoterapia", 
    "Cirurgia", "Mudança de estilo de vida", "Dieta especial", 
    "Acompanhamento regular", "Tratamento com antibióticos"
]

# Criando 200 prontuários com possibilidade de campo 'tratamento'
for i in range(1, 201):
    prontuario = {
        "id": i,
        "nome": random.choice(nomes),
        "diagnóstico": random.choice(diagnosticos),
        "descrição": random.choice(descricoes)
    }
    
    # Aleatoriamente adicionando o campo 'tratamento' em alguns prontuários
    if random.choice([True, False]):
        prontuario["tratamento"] = random.choice(tratamentos)
    
    # Salvando cada prontuário em um arquivo JSON individual
    json_file_path = os.path.join("./", f'prontuario_{i}.json')
    with open(json_file_path, 'w') as json_file:
        json.dump(prontuario, json_file, indent=4)

json_folder_path
