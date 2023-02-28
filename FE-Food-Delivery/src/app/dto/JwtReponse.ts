export class JwtReponse {
  token: string;
  id: number;
  name: string;
  roles: any[];


  constructor(token: string, id: number, name: string, roles: any[]) {
    this.token = token;
    this.id = id;
    this.name = name;
    this.roles = roles;
  }
}
