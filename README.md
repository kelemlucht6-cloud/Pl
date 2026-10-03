# ❄️ FROST SECURITY SCANNER EXTREME

Mod cliente Fabric para auditoria **passiva, autorizada e baseada em evidências** de Minecraft Java 1.21.11.

## O que é realmente implementado

- Motor de regras transparentes com severidade, confiança, evidências e histórico.
- Monitoramento de sessão, latência observável, desconexões e limites de memória para eventos.
- Reconhecimento do servidor a partir de informações que o cliente realmente recebe.
- Banco local extensível de vulnerabilidades (JSON) e busca por componente/CVE.
- Auditoria local de arquivos de permissões fornecidos pelo administrador, incluindo indicadores de wildcard.
- Detector de anomalias baseado em métricas observadas/sintéticas.
- Relatórios TXT, JSON e HTML.
- Laboratório sem contato com servidores públicos.
- Escopo autorizado e configuração local.
- Comandos `/frostscan` e atalhos de interface.
- Código modular e testes unitários.

## Limitações importantes

Um mod **somente cliente** não pode confirmar com confiabilidade configurações privadas do servidor, arquivos remotos, plugins ocultos ou vulnerabilidades que exigem acesso administrativo. Ele também não deve fingir que captura todos os pacotes apenas por estar instalado no cliente. Por isso, o analisador de pacotes expõe uma estrutura de eventos para integrações seguras e o monitoramento baseia-se apenas em telemetria observável.

Não há exploração automática, brute force, execução de comandos remotos, leitura de arquivos privados ou varredura invasiva.

## Compilar no Termux

1. Instale Java 21 e Git.
2. Instale Gradle 8.x/compatível ou gere o wrapper localmente.
3. Entre na pasta do projeto.
4. Execute `gradle build`.
5. O JAR remapeado ficará em `build/libs/`.

Para uso offline, pré-baixe as dependências do Gradle/Fabric em uma máquina com internet e depois use o cache do Gradle.

## Versões verificadas

- Minecraft 1.21.11
- Java 21
- Fabric API 0.141.6+1.21.11
- Fabric Loader 0.19.2
- Fabric Loom 1.15.5

## Fontes de inteligência

O banco local aceita registros importados de fontes confiáveis. A atualização de NVD/avisos oficiais deve ser feita conscientemente pelo administrador; o mod não envia dados automaticamente.
