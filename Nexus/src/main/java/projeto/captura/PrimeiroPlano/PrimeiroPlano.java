package projeto.captura.PrimeiroPlano;

import com.github.britooo.looca.api.core.Looca;

public class PrimeiroPlano {
    Looca looca = new Looca();
    private Integer pid;
    private String name;
    private Double usoCPU;
    private Double usoMem;
    private Double usoDisk;

    public void dadosPrimeiro(){
        int size = looca.getGrupoDeProcessos().getProcessos().size();

        for (int i = 0; i < size; i++) {
            pid = looca.getGrupoDeProcessos().getProcessos().get(i).getPid();
            name = looca.getGrupoDeProcessos().getProcessos().get(i).getNome();
            usoCPU = looca.getGrupoDeProcessos().getProcessos().get(i).getUsoCpu();
            usoMem = looca.getGrupoDeProcessos().getProcessos().get(i).getUsoMemoria();
            usoDisk = ((Double.valueOf(looca.getGrupoDeProcessos().getProcessos().get(i).getBytesUtilizados()) / 1024) / 1024) / 1024;

            System.out.println("""
                    Pid: %d
                    Nome: %s
                    Uso de CPU: %.2f
                    Uso de RAM: %.2f
                    Uso de Disco: %.2f
                    """.formatted(pid, name, usoCPU, usoMem, usoDisk));


        }
    }

    public void armazenarProcessos() {

    }
}
