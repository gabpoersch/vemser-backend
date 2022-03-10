--RIGHT OUTER JOINS
--PESSOA E CONTATO
SELECT * FROM PESSOA p 
RIGHT OUTER JOIN CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA);

--PESSOA, PXPE E EP
SELECT pxpe.ID_PESSOA, p.NOME, ep.LOGRADOURO FROM PESSOA p
RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (pxpe.ID_PESSOA = p.ID_PESSOA) 
RIGHT OUTER JOIN ENDERECO_PESSOA ep ON (ep.ID_ENDERECO = pxpe.ID_ENDERECO);

--TODAS TABELAS
SELECT p.NOME, c.NUMERO, ep.LOGRADOURO, pxpe.ID_PESSOA FROM PESSOA p
RIGHT OUTER JOIN CONTATO c ON (c.ID_PESSOA  = p.ID_PESSOA)
RIGHT OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (pxpe.ID_PESSOA = p.ID_PESSOA)
RIGHT OUTER JOIN ENDERECO_PESSOA ep ON (ep.ID_ENDERECO  = pxpe.ID_ENDERECO);

--OUTER FULL JOINS
--PESSOA E CONTATO
SELECT * FROM PESSOA p 
FULL OUTER JOIN CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA);

--PESSOA, PXPE E EP
SELECT pxpe.ID_PESSOA, p.NOME, ep.LOGRADOURO FROM PESSOA p
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (pxpe.ID_PESSOA = p.ID_PESSOA) 
FULL OUTER JOIN ENDERECO_PESSOA ep ON (ep.ID_ENDERECO = pxpe.ID_ENDERECO);

--TODAS TABELAS
SELECT p.NOME, c.NUMERO, ep.LOGRADOURO, pxpe.ID_PESSOA FROM PESSOA p
FULL OUTER JOIN CONTATO c ON (c.ID_PESSOA  = p.ID_PESSOA)
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (pxpe.ID_PESSOA = p.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA ep ON (ep.ID_ENDERECO  = pxpe.ID_ENDERECO);


--EXISTS
--PESSOAS Q TEM ENDEREÇO
SELECT p.NOME, p.ID_PESSOA FROM PESSOA p
WHERE EXISTS (SELECT pxpe.ID_PESSOA FROM PESSOA_X_PESSOA_ENDERECO pxpe 
			WHERE pxpe.ID_PESSOA = p.ID_PESSOA);

--IDNOMEIDLOGRADOURO	
SELECT p.NOME, p.ID_PESSOA, ep.ID_ENDERECO, ep.LOGRADOURO FROM PESSOA p 
INNER JOIN ENDERECO_PESSOA ep ON (p.ID_PESSOA = ep.ID_ENDERECO)
WHERE EXISTS (SELECT pxpe.ID_PESSOA FROM PESSOA_X_PESSOA_ENDERECO pxpe 
			WHERE pxpe.ID_PESSOA = p.ID_PESSOA);
			