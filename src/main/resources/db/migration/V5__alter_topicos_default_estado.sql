ALTER TABLE topicos
ALTER COLUMN estado_topico SET DEFAULT TRUE;

UPDATE topicos
SET estado_topico = TRUE
WHERE estado_topico IS FALSE OR estado_topico IS NULL;