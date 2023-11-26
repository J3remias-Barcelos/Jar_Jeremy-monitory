package projeto;

import org.json.JSONObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

    public class BotSlack {
        // Pegar do Monitoramento as informações dos componente e puxar como parametro para enviar ao slack

        private String construirMensagemDePorcentagemIndividual(String componente, double porcentagem) {
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            return """
        :rotating_light: *ALERTA* :rotating_light:
        > Componente: %s
        > Utilização: *%.2f%%*
        > Data/Hora: %s""".formatted(componente, porcentagem, dataHora);
        }

    public void notificarUsoCPUPorcentagem(String CPU, double porcentagem) {
        String mensagem = construirMensagemDePorcentagemIndividual(CPU, porcentagem);
        enviarMensagemSlack(mensagem);
    }

    public void notificarUsoMemoriaPorcentagem (String memoria, double porcentagem) {
        String mensagem = construirMensagemDePorcentagemIndividual(memoria, porcentagem);
        enviarMensagemSlack(mensagem);
    }

    public void notificarUsoDiscoPorcentagem(String disco , double porcentagem) {
        String mensagem = construirMensagemDePorcentagemIndividual(disco, porcentagem);
        enviarMensagemSlack(mensagem);
    }

    private void enviarMensagemSlack(String mensagem) {
        JSONObject json = new JSONObject();
        json.put("text", mensagem);
        try {
            Slack.sendMessage(json);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
