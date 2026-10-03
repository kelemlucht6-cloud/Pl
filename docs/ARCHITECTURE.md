# Arquitetura

`core` coordena contexto, regras, achados e risco. `network` mantém telemetria de sessão. `packets` fornece o modelo limitado de eventos de pacotes. `recon` representa o que o cliente observa sobre o servidor. `audit`, `vulnerabilities` e `permissions` executam verificações não invasivas. `detection` correlaciona padrões. `reports` serializa resultados. `storage` persiste dados locais. `dashboard` é a UI. `laboratory` fornece cenários sintéticos. `commands` integra o mod ao cliente.

As operações de análise não devem bloquear a thread de renderização; futuras verificações externas devem usar executores canceláveis e limites de tempo.
