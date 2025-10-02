public class principal {
    
    public static void main(String[] args) {
        System.out.println("Instanciando um objeto aluno...");

        Aluno joao = new Aluno();
        joao.setNome("Joao da Silva");
        joao.setProntuario("12345");

        System.out.println("Aluno: " + joao.getProntuario() + "-"+ joao.getNome());
    }
}
