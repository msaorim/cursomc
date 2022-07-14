package br.com.msaorim.cursomc.entities.enums;

public enum ClienteEnum {

	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int codigo;
	private String descricao;
	
	private ClienteEnum(int cod, String descr) {
		this.codigo = cod;
		this.descricao = descr;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static ClienteEnum toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(ClienteEnum tipo : ClienteEnum.values()) {
			if(cod.equals(tipo.getCodigo())) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
