# T1-POO

                                      Sistema	de	Composição	de	Trens
                           
Uma	 empresa	 ferroviária	 de	 transporte	 de	 cargas	 possui	 um	 pátio	 central	 onde	 ficam	
estacionados seus	 vagões	 e	 locomotivas.	 A	 empresa	 necessita	 de	 um	 sistema	 que	 permita	
organizar	as	composições	(trens)	que	irão	atender	as	diferentes	demandas	de	carga	da	empresa.
Uma	 composição	 (trem)	é	 composta por	 um	conjunto	 de	locomotivas	e	 por	 um	conjunto	 de	
vagões	 de	 carga.	Tanto	as	 locomotivas	 como	 os	 vagões	 devem	 ser	 selecionados	a	 partir	 dos	
cadastros	 de	 locomotivas	 e	 vagões.	 Este	 mantém não	 apenas	 as	 informações	 relativas	 as	
características	das	locomotivas	e	vagões	como	também	seu	estado,	isto	é,	se	já	está em	uso	em	
alguma	composição	ou	não. As	locomotivas	e	vagões	devem	ser	selecionados	na	ordem	em	que	
serão	engatados	na	composição	respeitando-se	as	seguintes	regras:

• As	locomotivas	devem	ser	as	primeiras	a	serem	selecionadas.	Não	é	possível	“engatar”	
uma	locomotiva	após	um	vagão.

• O	total	de	vagões	que	podem	ser	engatados	devem	respeitar	as	limitações	do	conjunto	
de	locomotivas (peso	máximo	que	conseguem	puxar	e	número	máximo	de	vagões	que	
conseguem	tracionar). Para	o	cálculo	do	peso	máximo	considerar	o	peso	do	vagão	com	
carga	máxima.

o Observação:	a	partir	da	segunda	locomotiva	engatada	a	capacidade	total	do	
conjunto	de	locomotivas	deve	ser	reduzida	em	10%	a	cada	nova	locomotiva	
engatada.	Exemplo:	suponha	que	todas	as	locomotivas	tenham	capacidade	
para	tracionar	50	vagões.	Uma	composição	com	uma	locomotiva	consegue	
tracionar	50	vagões,	com	duas	locomotivas	90	vagões	e	com	3	locomotivas	135	
vagões.

• Só	é	possível	engatar	uma	locomotiva	ou	vagão	por	vez	e	sempre	no	final	do	trem.	A	
locomotiva	ou	vagão	engatados	deixam	de	estar	“livres”	para	serem	usados	em	outra	
composição.

• Só	é	possível	desengatar	uma	locomotiva	ou	vagão	por	vez	e	sempre	do	final	do	trem.	
A	locomotiva	ou	vagão	desengatado	ficam	livres	para	serem	usados	em	outra	
composição.

As	informações	que	são	mantidas	em	relação	as	locomotivas,	vagões	e	composições	são	as	que	
seguem.
trem.Locomotiva:
• Identificador	da	locomotiva	(int)
• Peso	máximo	(em	toneladas)	que	consegue	puxar (double)
• Número	máximo	de	vagões	que	consegue	tracionar (int)
• Referência	para	a	composição	que	está	integrando	no	momento	ou	“null” se	está	livre

Vagão:
• Identificador	do	vagão (int)
• Capacidade	máxima	de	carga	em	toneladas	(double)
• Referência	para	a	composição	que	está integrando	no	momento	ou	“null”	se	está	livre

Composição:
• Identificador	da	composição
• Lista	de	carros ferroviários	(locomotivas	ou	vagões)	que	compõe	o	trem

As	informações	relativas	a	vagões,	trens	e	composições	são	armazenadas	em	arquivos	texto.
Com	base	nas	informações	apresentadas	deve	ser	desenvolvido	um	sistema	em	linguagem	de	
programação	Java	que	permita	montar	e	desmontar	composições	utilizando	as	locomotivas	e	
vagões	pertencentes	a	empresa.	O	cadastramento	de	novas	locomotivas	e/ou	vagões	deve	ser	
feito	diretamente	nos	arquivos	texto,	não	sendo parte	deste	sistema. O	sistema	deve	ter	opções	
para:

1- Criar	uma	nova	composição
• Esta	operação	exige	que	se	indique	o	identificador	da	composição	e	a	primeira	
locomotiva.	A	primeira	locomotiva	nunca	pode	ser	removida.	Para	liberar	esta	
locomotiva	é	necessário	desfazer	a	composição.

2- Editar	uma	composição
• Inicialmente	 deve-se	 indicar	 o	 identificador	 da	 composição	 a	 ser	 editada.	 A	
partir	de	então	ficam	liberadas	as	seguintes	operações:
• Inserir	uma	locomotiva (informar	identificador) respeitando	restrições
• Inserir	um	vagão (informar	identificador) respeitando	restrições
• Remover	o	último	elemento	da	composição
• Listar	locomotivas	livres
• Listar	vagões	livres
• Encerrar	a	edição	da	composição

3- Listar	todas	as	composições	editadas

4- Desfazer	uma	composição
• Deve-se	 indicar	 o	 identificador	 da	 composição.	 A	 partir	 de	 então	 todos	 seus	
vagões	e	locomotivas	devem	ser	liberados	e	a	composição	excluída	da	lista	de	
composições.
5- Fim
• Encerra	 o	 programa	 atualizando	 as	 informações	 relativas	 às	 composições,	
vagões	e	locomotivas	nos	arquivos	texto.

O	objetivo	desta tarefa é	verificar	se	os	conceitos	de	herança,	polimorfismo,	classes	abstratas	e	
interfaces	 estão	 bem	 compreendidos.	 A	tarefa	 pode	 ser	 desenvolvida	 em	 equipes	 de	 até	 3	
integrantes	desde	que	a	equipe	esteja	cadastrada	como	“grupo”	no	Moodle.	A	entrega	deve	ser	
feita	pelo	Moodle	em	arquivo	“.zip”	contendo	todos	os	arquivos	fonte	do	sistema,	bem	como	
informações	para	sua	compilação	e	execução
