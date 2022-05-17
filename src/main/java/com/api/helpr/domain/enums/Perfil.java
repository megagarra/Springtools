package com.api.helpr.domain.enums;

public enum Perfil {
	ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");

	private Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//GET -> BUSCAR INFORMAÇÃO
	//SET -> ATRIBUIR ALGUMA INFORMAÇÃO
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	

	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		//Vai em perfil, cria um objeto x e a cada loop x vai ser um valor do enum
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil Inválido");
	}


}