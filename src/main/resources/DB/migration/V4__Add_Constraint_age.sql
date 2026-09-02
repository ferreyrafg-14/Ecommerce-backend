ALTER TABLE usuario
ALTER COLUMN edad SET NOT NULL;

ALTER TABLE usuario
ADD CONSTRAINT chk_usuario_edad CHECK (edad > 0)