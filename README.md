# garajeNuevo

Collection<String> col1 new HashSet();

Map mapa1 = new HashMap<>();
Map mapa2 = new TreeMap<>(); //ordena ascendente

mapa1.put("2123223", new Plaza());
mapa1.put("3123223", new Plaza());
mapa1.put("4123223", new Plaza());

mapa2.put("2123223", new Plaza());
mapa2.put("3123223", new Plaza());
mapa2.put("4123223", new Plaza());




public void listarClientes() {
	Map<String, Cliente> clientes = GarageMain.getGaraje().getClientes();
	syso clientes.keySet();
	syso clientes.values();

}
