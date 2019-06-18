import { User } from '../model/user.model';

export class Project {
    id_project?: number;
    owner: User;
    startProject?: Date;
    title: string;
    field?: string;
    perspective?: string;
    program?: string;
    strategicObjective?: string;
}
