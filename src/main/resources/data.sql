INSERT INTO
    application_user (first_name, last_name, email, password)
VALUES
    -- superadmin@example.com / hard
    ('Jan', 'Kowalski', 'superadmin@example.com', '{bcrypt}$2a$10$Ruu5GtmSVkfLeuGfz/wHUuzflCcMbwJHSBo/.Wui0EM0KIM52Gs2S');

INSERT INTO
    user_role (name, description)
VALUES
    ('ADMIN', 'Ma dostęp do wszystkiego'),
    ('USER', 'Dostęp tylko do odczytu');

INSERT INTO
    user_roles (user_id, role_id)
VALUES
    (1, 1);

INSERT INTO
    City (name, longitude, latitude, state, country)
VALUES
    ('New York', -74.006, 40.7128, 'New York', 'United States'),
    ('Paris', 2.3522, 48.8566, 'Ile-de-France', 'France'),
    ('Sydney', 151.2093, -33.8688, 'New South Wales', 'Australia');

INSERT INTO
    Hours (date, sunrise, sunset, city_id)
VALUES
    ('2023-10-31', '06:30:00', '18:30:00', 1),
    ('2023-10-31', '06:45:00', '18:15:00', 2),
    ('2023-10-31', '07:00:00', '18:00:00', 3);